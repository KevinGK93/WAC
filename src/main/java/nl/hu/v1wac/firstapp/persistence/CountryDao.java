package nl.hu.v1wac.firstapp.persistence;

import java.util.List;

import nl.hu.v1wac.firstapp.model.Country;

public interface CountryDao {
	public boolean save(Country country);
	public List<Country> findAll();
	public List<Country> find10LargestPopulations();
	public Country findByCode(String code);
	public boolean update(Country country);
	public List<Country> find10LargestSurfaces();
	public boolean delete(Country country);

}