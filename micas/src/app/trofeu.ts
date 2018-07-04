import { Jogo } from "./jogo";


export class Trofeu {
  id: number;
  descicao: string;
  valor : number;
  pontos : Pontos;
  registo : Registo;
}

export class Pontos{
  id : number;
  pontos: number;
  tipo : string;
}

export class Registo{
  id : number;
  //data : string;
  //tempo : number;
  progresso : Progresso;
}

export class Progresso{
  id : number;
  jogo : Jogo;
  //utilizador : User;
  //favorito : boolean;
}

