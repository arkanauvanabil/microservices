package arkan.pelanggan.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import arkan.pelanggan.model.Pelanggan;
import arkan.pelanggan.service.PelangganService;

@RestController
@RequestMapping("/api/pelanggan")
public class PelangganController {

    @Autowired
    private PelangganService pelangganService;

    @GetMapping
    public List<Pelanggan> getAllPelanggan(){
        return pelangganService.getAllPelanggan();
    }

    @GetMapping("/{id}")
    public Pelanggan getPelangganById(@PathVariable Long id){
        return pelangganService.getPelangganByid(id);
    }

    @PostMapping
    public Pelanggan createPelanggan(@RequestBody Pelanggan pelanggan){
        return pelangganService.createPelanggan(pelanggan);
    }

    @DeleteMapping("/{id}")
    public void deletePelanggan(@PathVariable Long id){
        pelangganService.deletePelanggan(id);
    }
}