export const enum Billstatus {
    PAID = 'PAID',
    PENDING = 'PENDING',
    CANCELLED = 'CANCELLED'
}

export interface IBill {
    id?: number;
    prezzo?: number;
    billstatus?: Billstatus;
    assignmentId?: number;
}

export class Bill implements IBill {
    constructor(public id?: number, public prezzo?: number, public billstatus?: Billstatus, public assignmentId?: number) {}
}
