import {Injectable} from '@angular/core';
import {Http, Headers, Request, RequestOptions, RequestMethod, Response} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/do';
import {Observable} from 'rxjs/Observable';
import {environment} from '../../../../environments/environment';


@Injectable()
export class ApiService {

  private baseURL = environment.apiURL;



  constructor(private http: Http) {}

  get(url: string): Observable<object[]> {
    return this.request(url, RequestMethod.Get);
  }
  post(url: string, body: Object) {
    return this.request(url, RequestMethod.Post, body);
  }

  put(url: string, body: Object) {
    return this.request(url, RequestMethod.Put, body);
  }

  delete(url: string) {
    return this.request(url, RequestMethod.Delete);
  }


  request(url: string, method: RequestMethod, body?: Object) {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    /*
     * TO Do to fetch value from cookie. Remove hard coding later
     */
    headers.append('SM_USER', 'uiuser');

    const requestOptions = new RequestOptions({
      url: `${this.baseURL}/${url}`,
      method: method,
      headers: headers
    });


    if (body) {
      requestOptions.body = body;
    }

    const request = new Request(requestOptions);
    console.log('calling service url->' + requestOptions.url);
    return this.http.request(request)
      /*.do(result => console.log('RECEIVED', result, 'at', new Date())) */
      .map(method === RequestMethod.Post ? unwrapHeader : unwrapData)
      .catch((res: Response) => handleError(res));

  }

}

function unwrapHeader(res: Response) {
  return res.headers.get('location');
}

function unwrapData(res: Response) {
  return res.json();
}

function handleError(res: Response) {

  const statusCode = res.status;

  const body = res.json();

  const error = {
    statusCode: statusCode,
    error: body.error
  };

  console.log('Service Error statusCode : ' + error.statusCode + ' error: ' + error.error);

  return Observable.throw(error);
}
