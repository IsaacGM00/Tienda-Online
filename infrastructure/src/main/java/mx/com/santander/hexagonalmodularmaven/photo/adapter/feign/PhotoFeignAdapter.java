package mx.com.santander.hexagonalmodularmaven.photo.adapter.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.com.santander.hexagonalmodularmaven.photo.adapter.entity.PhotoEntity;

@FeignClient(name = "${feign.name}", url = "${feign.base-url}")
public interface PhotoFeignAdapter {

	@RequestMapping(method = RequestMethod.GET, value = "${feign.photo-resource}")
    List<PhotoEntity> getPhotos();

    @RequestMapping(method = RequestMethod.GET, value = "${feign.photo-resource}/{id}", produces = "application/json")
    PhotoEntity getPhoto(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.POST, value = "${feign.photo-resource}")
    PhotoEntity create(PhotoEntity photo);

}
