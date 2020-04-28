import { FloorDTO } from 'src/dto/floordto';



export class ParkingplaceDTO{


    id: number;

    numberplace: number;

    floor: FloorDTO = new FloorDTO();

 /*    constructor(){
        this.id = null;
        this.numberplace= null;
        this.floor= new FloorDTO();
    } */
}