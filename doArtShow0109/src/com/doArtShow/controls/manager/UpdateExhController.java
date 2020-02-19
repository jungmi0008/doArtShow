package com.doArtShow.controls.manager;

import java.util.Map;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.ManagerDao;
import com.doArtShow.dto.ExhibitionDto;

public class UpdateExhController implements Controller {
	ManagerDao managerDao;

	public UpdateExhController setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
		
		return this;
	}
	
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("### UpdateExhController ###");
		
		if (model.get("modifyExhibitionDto") == null) {
			int exhID = Integer.parseInt((String) model.get("exhID"));
			
			ExhibitionDto exhDto = new ExhibitionDto();
			exhDto = managerDao.getExhibition(exhID);
			
			model.put("exhDto", exhDto);

			return "manager/exh/modifyExh.jsp";			
		} else {
			ExhibitionDto modifyExhibitionDto = (ExhibitionDto) model.get("modifyExhibitionDto");
			
			int resultUpdateExhContent = managerDao.updateExhContent(modifyExhibitionDto);
			
			if (resultUpdateExhContent > 0) {
				int resultUpdateImageFile = managerDao.updateImageFile(modifyExhibitionDto);
				
				if (resultUpdateImageFile > 0) {
					int exhID = modifyExhibitionDto.getExhID();
					
					int resultDeleteArtShowTag = managerDao.deleteExhListTags(exhID);
					
					if (resultDeleteArtShowTag > 0) {
						String[] exhGubun3 = modifyExhibitionDto.getExhGubun3();
						
						for (int i = 0; i < exhGubun3.length; i++) {
							int resultUpdateExhGubun3 = managerDao.updateExhListTags(exhID, exhGubun3[i]);
							
							if (resultUpdateExhGubun3 <= 0) {
								return "updateArtShowTag fail";
							}
						}

						return "success";
					} else {
						return "deleteArtShowTag fail";
					}
				} else {
					return "updateImageFile fail";
				}
			} else {
				return "updateExhContent fail";
			}
		}
		
	}


}
