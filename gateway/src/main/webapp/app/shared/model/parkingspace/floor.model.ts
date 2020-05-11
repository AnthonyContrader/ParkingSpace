export interface IFloor {
    id?: number;
    numberFloor?: number;
}

export class Floor implements IFloor {
    constructor(public id?: number, public numberFloor?: number) {}
}
