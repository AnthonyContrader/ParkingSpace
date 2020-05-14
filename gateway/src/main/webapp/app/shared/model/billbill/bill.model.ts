export const enum Billstatus {
    PAID = 'PAID',
    PENDING = 'PENDING',
    CANCELLED = 'CANCELLED'
}

export interface IBill {
    id?: number;
    prezzo?: number;
    status?: Billstatus;
    assignmentbId?: number;
}

export class Bill implements IBill {
    constructor(public id?: number, public prezzo?: number, public status?: Billstatus, public assignmentbId?: number) {}
}
