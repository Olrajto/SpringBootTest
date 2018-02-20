import { Injectable} from "@angular/core";

@Injectable()
export class Configuration {

  private server = 'http://localhost:8080/';
  private apiUrl = 'api/';
  public serverApiUrl = this.server + this.apiUrl;
}
