package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cursos.model.Curso;

@RestController
public class CursosController {
	private List<Curso> cursos;
	@PostConstruct
	public void init() {
		cursos=new ArrayList<>();
		cursos.add(new Curso("Spring",25,"tarde"));
		cursos.add(new Curso("Spring boot",20,"tarde"));
		cursos.add(new Curso("Python",30,"tarde"));
		cursos.add(new Curso("Java EE",50,"fin de semana"));
		cursos.add(new Curso("Java b�sico",30,"ma�ana"));
	}
	@GetMapping(value="cursos",produces=MediaType.APPLICATION_JSON_VALUE)  //Nos lo devuelve en este formato en el navegador
	public List<Curso> getCursos(){
		return cursos;
	}
	
	@GetMapping(value="curso",produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso getCurso() {
		return new Curso("Java",100,"Ma�ana");
	}

	@GetMapping(value="cursos/{name}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> buscarCursos(@PathVariable("name") String nombre){
		List<Curso> aux=new ArrayList<>();
		for(Curso c:cursos) {
			if(c.getNombre().contains(nombre)) {
				aux.add(c);
			}
		}
		return aux;
	}
}

//@RestController
//public class CursosController{
//    @GetMapping(value= "curso", produces =MediaType.APPLICATION_JSON_VALUE)
//    public Curso getCurso(){
//       return new Curso("Java",100,"mañana");
//}
//Arrancamos el servicio y nos da un error porque está en un paquete distinto al paquete principal. localhost:8080/curso