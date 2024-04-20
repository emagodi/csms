package zw.co.zetdc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import zw.co.zetdc.entities.Material;
import zw.co.zetdc.payload.request.MaterialRequest;
import zw.co.zetdc.payload.response.MaterialResponse;
import zw.co.zetdc.service.MaterialService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class MaterialController {


    private final MaterialService materialService;

    @PostMapping("/material")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE') and hasAnyRole('DISTRICTMANAGER')")
    public void createMaterial(@RequestBody MaterialRequest materialRequest){
        materialService.createMaterial(materialRequest);
        log.info("Material {} created");
    }

    @GetMapping("/materials")
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole('DISTRICTMANAGER')")
    @ResponseStatus(HttpStatus.OK)
    public List<MaterialResponse> getAllMaterials() {
        return materialService.getAllMaterials();
    }


    @GetMapping("/material/{id}")
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole('DISTRICTMANAGER')")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Material> getMaterialById(@PathVariable Long id) {
        Material material = materialService.getMaterialById(id);
        if (material != null) {
            return ResponseEntity.ok(material);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
