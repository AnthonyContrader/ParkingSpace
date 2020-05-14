import { Moment } from 'moment';

export interface IAssignmentP {
    id?: number;
    car?: number;
    park?: number;
    entryDateTime?: Moment;
}

export class AssignmentP implements IAssignmentP {
    constructor(public id?: number, public car?: number, public park?: number, public entryDateTime?: Moment) {}
}
