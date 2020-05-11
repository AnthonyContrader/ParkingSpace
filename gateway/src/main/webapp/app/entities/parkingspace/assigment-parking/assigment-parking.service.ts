import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IAssigmentParking } from 'app/shared/model/parkingspace/assigment-parking.model';

type EntityResponseType = HttpResponse<IAssigmentParking>;
type EntityArrayResponseType = HttpResponse<IAssigmentParking[]>;

@Injectable({ providedIn: 'root' })
export class AssigmentParkingService {
    private resourceUrl = SERVER_API_URL + 'parkingspace/api/assigment-parkings';

    constructor(private http: HttpClient) {}

    create(assigmentParking: IAssigmentParking): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(assigmentParking);
        return this.http
            .post<IAssigmentParking>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(assigmentParking: IAssigmentParking): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(assigmentParking);
        return this.http
            .put<IAssigmentParking>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IAssigmentParking>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IAssigmentParking[]>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    private convertDateFromClient(assigmentParking: IAssigmentParking): IAssigmentParking {
        const copy: IAssigmentParking = Object.assign({}, assigmentParking, {
            entryDateTime:
                assigmentParking.entryDateTime != null && assigmentParking.entryDateTime.isValid()
                    ? assigmentParking.entryDateTime.toJSON()
                    : null
        });
        return copy;
    }

    private convertDateFromServer(res: EntityResponseType): EntityResponseType {
        res.body.entryDateTime = res.body.entryDateTime != null ? moment(res.body.entryDateTime) : null;
        return res;
    }

    private convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        res.body.forEach((assigmentParking: IAssigmentParking) => {
            assigmentParking.entryDateTime = assigmentParking.entryDateTime != null ? moment(assigmentParking.entryDateTime) : null;
        });
        return res;
    }
}
