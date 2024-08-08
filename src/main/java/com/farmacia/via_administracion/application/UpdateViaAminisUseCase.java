package com.farmacia.via_administracion.application;

import com.farmacia.via_administracion.domain.entity.ViaAdminis;
import com.farmacia.via_administracion.domain.service.ViaAdminisService;

public class UpdateViaAminisUseCase {
    private ViaAdminisService viaAdminisService;

    public UpdateViaAminisUseCase(ViaAdminisService viaAdminisService) {
        this.viaAdminisService = viaAdminisService;
    }

    public void execute(ViaAdminis viaAdminis) {
        viaAdminisService.updateViaAdminis(viaAdminis);
    }

}
