package sa.com.mcp.ai.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class MedicalDeviceAidPocController {

  private static final AtomicLong SEQ = new AtomicLong(10000);
  private static final Map<String, MedicalAidRequestRecord> REQUESTS = new ConcurrentHashMap<>();

  // 1) List devices
  @GetMapping("/assistive-devices")
  public List<AssistiveDeviceDto> listAssistiveDevices() {
    return List.of(
        new AssistiveDeviceDto("WHEELCHAIR", "كرسي متحرك"),
        new AssistiveDeviceDto("HEARING_AID", "سماعة طبية"),
        new AssistiveDeviceDto("WALKER", "مشاية"),
        new AssistiveDeviceDto("CRUTCHES", "عكازات")
    );
  }

  // 2) Submit request (single-step POC) — NO attachment requirement
  @PostMapping("/medical-device-aid/requests/submit")
  public ResponseEntity<?> submit(@RequestBody SubmitMedicalAidRequest req) {

    if (req.userId == null || req.userId.isBlank()) {
      return ResponseEntity.badRequest().body(error("Missing userId"));
    }
    if (req.deviceCode == null || req.deviceCode.isBlank()) {
      return ResponseEntity.badRequest().body(error("Missing deviceCode"));
    }
    if (!Boolean.TRUE.equals(req.declarationAccepted)) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error("Declaration must be accepted"));
    }

    // Simulated POC failure
    if (req.userId.toLowerCase().contains("blocked")) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error("User not eligible for this service (POC simulated)"));
    }

    String requestId = "REQ-" + SEQ.incrementAndGet();

    MedicalAidRequestRecord record = new MedicalAidRequestRecord(
        requestId,
        req.userId,
        req.deviceCode,
        "SUBMITTED",
        "تم تقديم طلب الإعانة المالية للأجهزة الطبية بنجاح",
        Instant.now().toString()
    );

    REQUESTS.put(requestId, record);

    return ResponseEntity.ok(new SubmitMedicalAidResponse(
        requestId,
        record.status,
        record.summary
    ));
  }

  // 3) Get request
  @GetMapping("/medical-device-aid/requests/{requestId}")
  public ResponseEntity<?> get(@PathVariable String requestId) {
    MedicalAidRequestRecord record = REQUESTS.get(requestId);
    if (record == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error("Request not found"));
    }
    return ResponseEntity.ok(record);
  }

  // 4) List requests by userId
  @GetMapping("/medical-device-aid/requests")
  public ResponseEntity<?> listByUser(@RequestParam("userId") String userId) {
    if (userId == null || userId.isBlank()) {
      return ResponseEntity.badRequest().body(error("Missing userId"));
    }

    List<MedicalAidRequestRecord> list = REQUESTS.values().stream()
        .filter(r -> r.userId.equals(userId))
        .sorted(Comparator.comparing(r -> r.createdAt))
        .toList();

    return ResponseEntity.ok(list);
  }

  private Map<String, Object> error(String message) {
    return Map.of("success", false, "message", message);
  }

  // DTOs
  public static class AssistiveDeviceDto {
    public String deviceCode;
    public String deviceName;
    public AssistiveDeviceDto(String deviceCode, String deviceName) {
      this.deviceCode = deviceCode;
      this.deviceName = deviceName;
    }
  }

  public static class SubmitMedicalAidRequest {
    public String userId;
    public String deviceCode;
    public Map<String, Object> measurements; // optional
    public Boolean declarationAccepted;
  }

  public static class SubmitMedicalAidResponse {
    public String requestId;
    public String status;
    public String summary;
    public SubmitMedicalAidResponse(String requestId, String status, String summary) {
      this.requestId = requestId;
      this.status = status;
      this.summary = summary;
    }
  }

  public static class MedicalAidRequestRecord {
    public String requestId;
    public String userId;
    public String deviceCode;
    public String status;
    public String summary;
    public String createdAt;

    public MedicalAidRequestRecord(String requestId, String userId, String deviceCode, String status, String summary, String createdAt) {
      this.requestId = requestId;
      this.userId = userId;
      this.deviceCode = deviceCode;
      this.status = status;
      this.summary = summary;
      this.createdAt = createdAt;
    }
  }
}
