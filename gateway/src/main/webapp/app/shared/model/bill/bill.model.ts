export const enum BillStatus {
    PAID = 'PAID',
    PENDING = 'PENDING',
    CANCELED = 'CANCELED'
}

export interface IBill {
    id?: number;
    price?: number;
    billStatus?: BillStatus;
    assignmentId?: number;
}

export class Bill implements IBill {
    constructor(public id?: number, public price?: number, public billStatus?: BillStatus, public assignmentId?: number) {}
}
