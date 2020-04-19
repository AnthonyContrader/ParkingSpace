import { Component , OnInit } from "@angular/core";
import { FloorDTO } from 'src/dto/floordto';
import { FloorService } from 'src/service/floor.service'

@Component({
    selector: 'app-floor',
    templateUrl: './floor.component.html',
    styleUrls: ['./floor.component.css']
})

export class FloorComponent implements OnInit {
    floor : FloorDTO[];
    floortoinsert : FloorDTO = new FloorDTO();

    constructor(private service : FloorService){
    }

    ngOnInit(){
        this.getFloor();
    }

    getFloor(){
        this.service.getAll().subscribe(floor => this.floor=floor);
    }

    insert(floor : FloorDTO){
        this.service.insert(floor).subscribe(()=> this.getFloor());
    }

    update(floor : FloorDTO){
        this.service.update(floor).subscribe(()=> this.getFloor());
    }

    delete(floor : FloorDTO){
        this.service.delete(floor.id).subscribe(() => this.getFloor());
    }

    clear(){
        this.floortoinsert = new FloorDTO();
    }

}
