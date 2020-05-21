export class BillDTO{
    id: number;
    price: number;
    billStatus: BillStatus;
    assignmentId: number;
}

enum BillStatus{
    PAID, PENDING, CANCELED
}