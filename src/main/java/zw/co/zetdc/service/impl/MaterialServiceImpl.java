package zw.co.zetdc.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import zw.co.zetdc.entities.Material;
import zw.co.zetdc.payload.request.MaterialRequest;
import zw.co.zetdc.payload.response.MaterialResponse;
import zw.co.zetdc.repository.MaterialRepository;
import zw.co.zetdc.service.MaterialService;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;


    public void createMaterial(MaterialRequest materialRequest){
        Material material = Material.builder()

                .itemCode(materialRequest.getItemCode())
                .description(materialRequest.getDescription())
                .unitOfMeasure(materialRequest.getUnitOfMeasure())
                .price(materialRequest.getPrice())
                .build();

        materialRepository.save(material);
    }

    public List<MaterialResponse> getAllMaterials() {
        List<Material> materials = materialRepository.findAll();
        return materials.stream().map(this::mapToMaterialResponse).toList();
    }

    private MaterialResponse mapToMaterialResponse(Material material) {
        return MaterialResponse.builder()
                .id(material.getId())
                .itemCode(material.getItemCode())
                .description(material.getDescription())
                .unitOfMeasure(material.getUnitOfMeasure())
                .price(material.getPrice())
                .build();
    }

    public Material getMaterialById(Long id) {
        return materialRepository.findById(id).orElse(null);
    }

}
