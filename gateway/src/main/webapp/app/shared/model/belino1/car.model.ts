export interface ICar {
    id?: number;
    model?: string;
    license?: string;
    personId?: number;
}

export class Car implements ICar {
    constructor(public id?: number, public model?: string, public license?: string, public personId?: number) {}
}
