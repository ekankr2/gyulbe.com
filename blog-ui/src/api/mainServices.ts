import { CreatePostRequest } from './types';
import axios from 'axios';

export const createPost = async (data: CreatePostRequest) => {
  const res = await axios.post('http://localhost:7777/post', data);
  return res.data;
};
