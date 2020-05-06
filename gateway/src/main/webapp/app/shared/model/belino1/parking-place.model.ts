export interface IParkingPlace {
    id?: number;
    numberPlace?: number;
    floorId?: number;
}

export class ParkingPlace implements IParkingPlace {
    constructor(public id?: number, public numberPlace?: number, public floorId?: number) {}
}
