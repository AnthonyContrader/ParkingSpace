import { Moment } from 'moment';

export interface IAssignmentParking {
    id?: number;
    car?: number;
    parkingplace?: number;
    entryDateTime?: Moment;
}

export class AssignmentParking implements IAssignmentParking {
    constructor(public id?: number, public car?: number, public parkingplace?: number, public entryDateTime?: Moment) {}
}
