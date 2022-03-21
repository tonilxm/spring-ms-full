package com.toni.user.httpclient;

import com.toni.user.vo.DepartmentVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("department-service")
public interface DepartmentHttpClient {
    @GetMapping("/departments/{id}")
    DepartmentVO findById(@PathVariable Long id);
}
