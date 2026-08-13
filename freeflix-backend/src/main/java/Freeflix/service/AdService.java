package Freeflix.service;

import Freeflix.model.AdSlot;
import Freeflix.repo.AdSlotRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdService {
  private final AdSlotRepository adRepo;

  public AdService(AdSlotRepository adRepo) {
    this.adRepo = adRepo;
  }

  public List<AdSlot> activeAds() {
    return adRepo.findByActiveTrue();
  }

  public AdSlot preroll() {
    return activeAds().stream().filter(a -> "preroll".equalsIgnoreCase(a.getName())).findFirst().orElse(null);
  }

  public AdSlot postroll() {
    return activeAds().stream().filter(a -> "postroll".equalsIgnoreCase(a.getName())).findFirst().orElse(null);
  }

  public List<AdSlot> midrolls() {
    return activeAds().stream().filter(a -> "midroll".equalsIgnoreCase(a.getName())).toList();
  }
}