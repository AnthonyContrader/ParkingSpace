import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IAssignmentB } from 'app/shared/model/billbill/assignment-b.model';

type EntityResponseType = HttpResponse<IAssignmentB>;
type EntityArrayResponseType = HttpResponse<IAssignmentB[]>;

@Injectable({ providedIn: 'root' })
export class AssignmentBService {
    private resourceUrl = SERVER_API_URL + 'billbill/api/assignment-bs';

    constructor(private http: HttpClient) {}

    create(assignmentB: IAssignmentB): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(assignmentB);
        return this.http
            .post<IAssignmentB>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(assignmentB: IAssignmentB): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(assignmentB);
        return this.http
            .put<IAssignmentB>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IAssignmentB>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IAssignmentB[]>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    private convertDateFromClient(assignmentB: IAssignmentB): IAssignmentB {
        const copy: IAssignmentB = Object.assign({}, assignmentB, {
            entryDateTime:
                assignmentB.entryDateTime != null && assignmentB.entryDateTime.isValid() ? assignmentB.entryDateTime.toJSON() : null
        });
        return copy;
    }

    private convertDateFromServer(res: EntityResponseType): EntityResponseType {
        res.body.entryDateTime = res.body.entryDateTime != null ? moment(res.body.entryDateTime) : null;
        return res;
    }

    private convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        res.body.forEach((assignmentB: IAssignmentB) => {
            assignmentB.entryDateTime = assignmentB.entryDateTime != null ? moment(assignmentB.entryDateTime) : null;
        });
        return res;
    }
}
