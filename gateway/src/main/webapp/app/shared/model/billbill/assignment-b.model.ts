import { Moment } from 'moment';

export interface IAssignmentB {
    id?: number;
    entryDateTime?: Moment;
    car?: number;
    parkplace?: number;
}

export class AssignmentB implements IAssignmentB {
    constructor(public id?: number, public entryDateTime?: Moment, public car?: number, public parkplace?: number) {}
}
