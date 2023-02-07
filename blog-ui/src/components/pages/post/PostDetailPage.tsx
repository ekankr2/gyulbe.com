import React from 'react';
import { useParams } from 'react-router-dom';
import { useGetPostInfo } from '../../../api/hooks/postHooks';
// @ts-ignore
import { ReactComponent as VerticalDots } from '../../../assets/dots-vertical.svg';

const PostDetailPage = () => {
  const { id } = useParams<{ id: string }>();
  const { data: postInfo } = useGetPostInfo(id);

  return (
    <>
      {postInfo && (
        <section className="mx-[20px] mt-[40px] md:mx-auto md:max-w-[750px]">
          <article className="border-b-[1px] border-solid border-gray-200 pb-[20px]">
            <img className="h-full max-h-[300px] w-full rounded-xl" src="/sample-img.jpg" alt="main-image" />
            <div className="flex w-full items-end justify-between">
              <div>
                <h1 className="mt-[20px] text-5xl font-bold">{postInfo.title}</h1>
                <p className="mt-[20px] text-sm text-zinc-400">{new Date(postInfo.createdAt).toLocaleDateString()}</p>
              </div>
              <div className="cursor-pointer">
                <VerticalDots width={24} height={24} fill="#a1a1aa" />
              </div>
            </div>
          </article>
          <article className="pt-[40px]">
            <p className="text-gray-600">{postInfo.content}</p>
          </article>
        </section>
      )}
    </>
  );
};

export default PostDetailPage;
