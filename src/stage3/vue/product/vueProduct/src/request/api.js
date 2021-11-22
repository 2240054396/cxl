import {get,post} from "./http";

export const validate =function (){
  return get('user/validate');
}

export const login =user=>{
  return post("user/login",user);
}
