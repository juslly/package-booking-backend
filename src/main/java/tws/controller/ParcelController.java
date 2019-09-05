package tws.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tws.entity.Parcel;
import tws.repository.ParcelMapper;


@RestController
@RequestMapping("/parcels")
public class ParcelController {
	
	@Autowired
    private ParcelMapper parcelMapper;
	
	@PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void createParcel(@RequestBody Parcel parcel) {
//		System.out.println("我来测试你的jie'guo"+parcel);
       parcelMapper.addParcel(parcel);
    }
	
	@GetMapping("")
    public ResponseEntity<List<Parcel>> getAll() {
        return ResponseEntity.ok(parcelMapper.selectAll());
    }
	
	@PatchMapping("/sendOrder")
    @ResponseStatus(HttpStatus.OK)
    public void updateParcel(@RequestBody Parcel parcel) {
    	
		parcelMapper.updateStatus(parcel);			
    	
    }
	
//	@GetMapping("/")
//    public Map<String, String> hello() {
//		System.out.println();
//        Map<String, String> result = new HashMap<>();
//        result.put("msg1", "hello");
//        result.put("msg2", "world");
////        return result;
//        return result;
//    }

}
