export class UserListDto {
  names: string[];
  frequencies: string[]
  constructor(names: string[], frequencies: string[]) {
    this.names = names;
    this.frequencies = frequencies;
  }
}
