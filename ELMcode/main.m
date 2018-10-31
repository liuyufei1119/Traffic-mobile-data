clear all;
close all;
clc;
%[TrainingTime, TestingTime, TrainingAccuracy, TestingAccuracy] =   ELM('train','test',0,1000,'sig');
[TrainingTime,TrainingAccuracy] = elm_train('train', 0, 1000, 'sig')%train function
[TestingTime, TestingAccuracy] = elm_predict('test')%test and predict function


%read data process data into a trainable format
sinc_test=importdata('newsin')%
%Transposed matrix
sinc_test1=sinc_test'
%Normalization
guiyi = mapminmax(sinc_test1, -1, 1)
sinc_test2=guiyi' 
b=sinc_test2(:,5);
sinc_test2(:,5)=sinc_test2(:,1);
sinc_test2(:,1)=b
dlmwrite('train',sinc_test2)%Put the processed data in the 'train' file