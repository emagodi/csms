package zw.co.zetdc.service;



import zw.co.zetdc.entities.Material;
import zw.co.zetdc.payload.request.MaterialRequest;
import zw.co.zetdc.payload.response.ApplicationResponse;
import zw.co.zetdc.payload.response.MaterialResponse;

import java.util.List;

public interface MaterialService {

    public void createMaterial(MaterialRequest materialRequest);
    public List<MaterialResponse> getAllMaterials();

    public Material getMaterialById(Long id);
}
