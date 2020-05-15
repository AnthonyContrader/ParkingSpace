import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IAssignmentParking } from 'app/shared/model/bill/assignment-parking.model';

type EntityResponseType = HttpResponse<IAssignmentParking>;
type EntityArrayResponseType = HttpResponse<IAssignmentParking[]>;

@Injectable({ providedIn: 'root' })
export class AssignmentParkingService {
    private resourceUrl = SERVER_API_URL + 'bill/api/assignment-parkings';

    constructor(private http: HttpClient) {}

    create(assignmentParking: IAssignmentParking): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(assignmentParking);
        return this.http
            .post<IAssignmentParking>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(assignmentParking: IAssignmentParking): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(assignmentParking);
        return this.http
            .put<IAssignmentParking>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IAssignmentParking>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IAssignmentParking[]>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    private convertDateFromClient(assignmentParking: IAssignmentParking): IAssignmentParking {
        const copy: IAssignmentParking = Object.assign({}, assignmentParking, {
            entryDateTime:
                assignmentParking.entryDateTime != null && assignmentParking.entryDateTime.isValid()
                    ? assignmentParking.entryDateTime.toJSON()
                    : null
        });
        return copy;
    }

    private convertDateFromServer(res: EntityResponseType): EntityResponseType {
        res.body.entryDateTime = res.body.entryDateTime != null ? moment(res.body.entryDateTime) : null;
        return res;
    }

    private convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        res.body.forEach((assignmentParking: IAssignmentParking) => {
            assignmentParking.entryDateTime = assignmentParking.entryDateTime != null ? moment(assignmentParking.entryDateTime) : null;
        });
        return res;
    }
}
