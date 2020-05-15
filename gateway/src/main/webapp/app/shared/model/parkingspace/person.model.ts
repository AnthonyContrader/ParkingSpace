export interface IPerson {
    id?: number;
    firstName?: string;
    lastName?: string;
}

export class Person implements IPerson {
    constructor(public id?: number, public firstName?: string, public lastName?: string) {}
}
