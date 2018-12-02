package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories;

import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Location;

public class LocationRepository extends Repository{
	private Class className = Location.class;
	private static LocationRepository instance;

	public static LocationRepository getInstance() {
		if(instance == null)
			instance = new LocationRepository();
		return instance;
	}

	@Override
	protected Class getClassName()
	{
		return className;
	}
}
