package arkan.pelanggan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arkan.pelanggan.model.Pelanggan;

import java.util.List;

@Service
public class PelangganService {

    @Autowired
    private arkan.pelanggan.Repository.PelangganRepository pelangganRepository;

    public List<Pelanggan> getAllPelanggan(){
        return pelangganRepository.findAll();
    }

    public Pelanggan getPelangganByid(Long id){
        return pelangganRepository.findById(id).orElse(null);
    }

    public Pelanggan createPelanggan(Pelanggan pelanggan){
        return pelangganRepository.save(pelanggan);
    }

    public void deletePelanggan(Long id){
        pelangganRepository.deleteById(id);
    }
}