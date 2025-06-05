package com.devops.patient_management.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class MetricsService {

    private final Counter getAllPatientsCounter;
    private final Counter getPatientByIdCounter;
    private final Timer requestTimer;

    public MetricsService(MeterRegistry registry) {
        this.getAllPatientsCounter = registry.counter("http_requests_total", "method", "GET", "endpoint", "/api/patients");
        this.getPatientByIdCounter = registry.counter("http_requests_total", "method", "GET", "endpoint", "/api/patients/{id}");
        this.requestTimer = registry.timer("http_request_duration_seconds", "method", "GET", "endpoint", "/api/patients");
    }

    public void incrementGetAllPatientsCounter() {
        getAllPatientsCounter.increment();
    }

    public void incrementGetPatientByIdCounter() {
        getPatientByIdCounter.increment();
    }

    public <T> T recordRequestDuration(java.util.function.Supplier<T> supplier) {
        return requestTimer.record(supplier);
    }

    public void recordDurationNanos(long startTimeNanos) {
        long duration = System.nanoTime() - startTimeNanos;
        requestTimer.record(duration, TimeUnit.NANOSECONDS);
    }
    metricsService.incrementGetAllPatientsCounter();
    return metricsService.recordRequestDuration(() -> patientService.getAllPatients());

}
