package com.goldenkey.module1;

import java.util.List;
import java.util.Optional;

public interface ImageService {
	public Image savOrUpdate(Image o);
	public void delete(Long id);
	public List<Image> findAll();
	public Optional<Image> findByID(long id);
}
