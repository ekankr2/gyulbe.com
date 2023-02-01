import { CreatePostRequest } from './types';
import axios from 'axios';
import mainRequest from './mainRequest';

export const createPost = async (data: CreatePostRequest) => {
  const res = await mainRequest.post('/posts', data);
  return res.data;
};
