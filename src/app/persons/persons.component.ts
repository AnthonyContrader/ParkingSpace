import { Component, OnInit } from '@angular/core';
import { PersonDTO } from 'src/dto/persondto';
import { PersonService } from 'src/service/person.service';
import { last } from '@angular/router/src/utils/collection';

@Component({
  selector: 'app-persons',
  templateUrl: './persons.component.html',
  styleUrls: ['./persons.component.css']
})
export class PersonsComponent implements OnInit {
  persons: PersonDTO[];
  persontoinsert: PersonDTO = new PersonDTO();
  personsSameLastName: PersonDTO[]=[];
  lastName= '';
  personcheck: PersonDTO = new PersonDTO();
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

  getPersonsByLastName(lastName){
    //il parametro non viene letto.
    this.lastName=lastName;
    //this.personsSameLastName=[];
    console.log('this is inserted lastname:' + lastName);
    for(let person of this.persons){
      if(person.lastName===lastName){
        this.personsSameLastName.push(person);
      }
    }
    console.log(this.personsSameLastName.length);
  }

}
