import { Component, OnInit } from '@angular/core';
import { PersonDTO } from 'src/dto/persondto';
import { PersonService } from 'src/service/person.service';

@Component({
  selector: 'app-persons',
  templateUrl: './persons.component.html',
  styleUrls: ['./persons.component.css']
})
export class PersonsComponent implements OnInit {
  persons: PersonDTO[];
  persontoinsert: PersonDTO = new PersonDTO();
  constructor(private service: PersonService) { }

  ngOnInit() {
    this.getPersons();
  }
  getPersons() {
    this.service.getAll().subscribe(persons => this.persons=persons);
    //throw new Error("Method not implemented.");
  }
  delete(person: PersonDTO){
    this.service.delete(person.id).subscribe(()=>this.getPersons());
  }
  update(person:PersonDTO){
    this.service.update(person).subscribe(()=>this.getPersons());
  }
  insert(person:PersonDTO){
    this.service.insert(person).subscribe(()=>this.getPersons());

  }
  clear(){
    this.persontoinsert=new PersonDTO();
  }

}
