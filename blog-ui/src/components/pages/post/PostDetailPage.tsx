import React from 'react';
import { useParams } from 'react-router-dom';
import { useGetPostInfo } from '../../../api/hooks/postHooks';

const PostDetailPage = () => {
  const { id } = useParams<{ id: string }>();
  const { data: postInfo } = useGetPostInfo(id);

  return (
    <>
      {postInfo &&
        <section className="mx-[20px] mt-[40px] md:mx-auto md:max-w-[750px]">
          <article>
            <div className="w-full">
              <img className="h-full max-h-[300px] w-full rounded-xl" src="/sample-img.jpg" alt="main-image" />
              <h1 className="mt-[20px] text-5xl font-bold">{postInfo.title}</h1>
              <p className="mt-[20px] text-sm text-zinc-400">{new Date(postInfo.createdAt).toLocaleDateString()}</p>
            </div>
          </article>
          <article className="mt-[50px]">
            <p className="text-gray-600">{postInfo.content}</p>
          </article>
        </section>
      }
    </>
  );
};

export default PostDetailPage;
