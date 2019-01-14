package net.itinajero.app.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.itinajero.app.model.Banner;
import net.itinajero.app.repository.BannersRepository;

@Service
public class BannerServiceJPA implements IBannerService{
	
	@Autowired
	BannersRepository bannerrepository;
	
	@Override
	public void save(Banner banner) {
		bannerrepository.save(banner);
		
	}

	@Override
	public void delete(int idBanner) {
		bannerrepository.deleteById(idBanner);
		
	}

	@Override
	public List<Banner> findAll() {
		return bannerrepository.findAll();
	}

	@Override
	public Banner findById(int idBanner) {
		Optional<Banner> optional = bannerrepository.findById(idBanner);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	

}
