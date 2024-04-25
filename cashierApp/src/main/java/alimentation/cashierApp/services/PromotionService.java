package alimentation.cashierApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alimentation.cashierApp.dao.PromotionRepository;
import alimentation.cashierApp.models.Promotion;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository PromotionRepository;


    // Add methods for Promotion-related operations here
    Iterable<Promotion> getAllPromotions(){
        return PromotionRepository.findAll();
    }

    Promotion getPromotionById(int id){
        Optional<Promotion> response = PromotionRepository.findById(id);
        if (response.isPresent()) {
            return response.get();
        }
        return null;
    }

    void addPromotion(Promotion Promotion){
        PromotionRepository.save(Promotion);
    }

    void updatePromotion(Promotion Promotion){
        PromotionRepository.save(Promotion);
    }

    void deletePromotion(int id){
        PromotionRepository.deleteById(id);
    }
}
