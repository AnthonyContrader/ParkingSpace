import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IAssignmentP } from 'app/shared/model/billPark/assignment-p.model';

type EntityResponseType = HttpResponse<IAssignmentP>;
type EntityArrayResponseType = HttpResponse<IAssignmentP[]>;

@Injectable({ providedIn: 'root' })
export class AssignmentPService {
    private resourceUrl = SERVER_API_URL + 'billpark/api/assignment-ps';

    constructor(private http: HttpClient) {}

    create(assignmentP: IAssignmentP): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(assignmentP);
        return this.http
            .post<IAssignmentP>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(assignmentP: IAssignmentP): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(assignmentP);
        return this.http
            .put<IAssignmentP>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IAssignmentP>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IAssignmentP[]>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    private convertDateFromClient(assignmentP: IAssignmentP): IAssignmentP {
        const copy: IAssignmentP = Object.assign({}, assignmentP, {
            entryDateTime:
                assignmentP.entryDateTime != null && assignmentP.entryDateTime.isValid() ? assignmentP.entryDateTime.toJSON() : null
        });
        return copy;
    }

    private convertDateFromServer(res: EntityResponseType): EntityResponseType {
        res.body.entryDateTime = res.body.entryDateTime != null ? moment(res.body.entryDateTime) : null;
        return res;
    }

    private convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        res.body.forEach((assignmentP: IAssignmentP) => {
            assignmentP.entryDateTime = assignmentP.entryDateTime != null ? moment(assignmentP.entryDateTime) : null;
        });
        return res;
    }
}
