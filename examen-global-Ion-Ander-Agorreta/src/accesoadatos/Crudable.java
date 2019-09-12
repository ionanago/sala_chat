package accesoadatos;

public interface Crudable<T> {
	
	public Iterable<T> getAll();
	public T getOne(long isbn);
	public void insertar(T objeto);
	public void eliminar(T objeto);
	public void modificar(T objeto);
	
	
}
