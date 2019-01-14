package net.itinajero.app.service;

import java.util.List;

import net.itinajero.app.model.Banner;

public interface IBannerService {

	void save(Banner banner);
	void delete(int idBanner);
	List<Banner> findAll();
	Banner findById(int idBanner);
	
}
