import { Moment } from 'moment';

export interface IAssigmentParking {
    id?: number;
    entryDateTime?: Moment;
    carId?: number;
    parkingplaceId?: number;
}

export class AssigmentParking implements IAssigmentParking {
    constructor(public id?: number, public entryDateTime?: Moment, public carId?: number, public parkingplaceId?: number) {}
}
