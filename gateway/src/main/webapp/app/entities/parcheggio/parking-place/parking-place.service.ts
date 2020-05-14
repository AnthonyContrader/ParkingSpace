import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IParkingPlace } from 'app/shared/model/parcheggio/parking-place.model';

type EntityResponseType = HttpResponse<IParkingPlace>;
type EntityArrayResponseType = HttpResponse<IParkingPlace[]>;

@Injectable({ providedIn: 'root' })
export class ParkingPlaceService {
    private resourceUrl = SERVER_API_URL + 'parcheggio/api/parking-places';

    constructor(private http: HttpClient) {}

    create(parkingPlace: IParkingPlace): Observable<EntityResponseType> {
        return this.http.post<IParkingPlace>(this.resourceUrl, parkingPlace, { observe: 'response' });
    }

    update(parkingPlace: IParkingPlace): Observable<EntityResponseType> {
        return this.http.put<IParkingPlace>(this.resourceUrl, parkingPlace, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IParkingPlace>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IParkingPlace[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
