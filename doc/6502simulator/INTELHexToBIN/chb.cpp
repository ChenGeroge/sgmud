
/*---------------------------------------------------------------------------
* Copyright (c) 2006 ����
*----------------------------------------------------------------------------
* RELEASE:
* REVISION:     
*----------------------------------------------------------------------------
* PURPOSE:

*  chb.cpp : Defines the entry point for the console application.
*
*
* NOTE: �뱣���ļ��������ԡ�
*
*
------------------------------------------------------------------------------*/

#include "stdafx.h"
#include "chb.h"

#include<fstream>
#include<sstream>
#include<string>
#include"IntelHexFmt.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif



/////////////////////////////////////////////////////////////////////////////
// The one and only application object

CWinApp theApp;

using namespace std;

int _tmain(int argc, TCHAR* argv[], TCHAR* envp[])
{
	int nRetCode = 0;

	CString m_inFile,m_outFile;
	ifstream inf; 
	ofstream outf;

	long SegAdr=0,LineAdr=0,LastWriteAdr=0,finalAdr=0;
	std::string src;
	std::stringstream ostr;
	IntelHexFmt ihf;	//intel hex�ļ���¼����

	// initialize MFC and print and error on failure
	if (!AfxWinInit(::GetModuleHandle(NULL), NULL, ::GetCommandLine(), 0))
	{
		// TODO: change error code to suit your needs
		cerr << _T("Fatal Error: MFC initialization failed") << endl;
		nRetCode = 1;
	}
	else
	{
		// TODO: code your application's behavior here.
		
		CFileDialog idlg(TRUE,"hex",NULL,NULL,"hex�ļ�(*.hex)|*.hex|");
		idlg.DoModal();
		m_inFile=idlg.GetPathName();

		CFileDialog odlg(TRUE,"bin",NULL,NULL,"Bin�ļ�(*.Bin)|*.Bin|");
		odlg.DoModal();
		m_outFile=odlg.GetPathName();

	//	std::string s_in(m_inFile.GetBuffer(1));   //CString תstd::string
	//	m_inFile.ReleaseBuffer();
	//	std::string s_out(m_outFile.GetBuffer(1));   //CString תstd::string
	//	m_inFile.ReleaseBuffer();
		if(m_inFile=="" ||m_outFile=="")
		{	
			AfxMessageBox("Դ,Ŀ���ļ�������Ϊ��");
			return 0;
		}

		inf.open(m_inFile.operator LPCTSTR());
		if(!inf.is_open())
		{
			AfxMessageBox("Դ�ļ���ʧ��");
			return 0;
		}

		outf.open(m_outFile.operator LPCTSTR(),ios::binary);
		if(!outf.is_open())
		{
			AfxMessageBox("Ŀ���ļ���ʧ��");
			return 0;
		}


		while(getline(inf,src))  //��Դ�ļ���һ��
		{
			ihf=src;
			int rcdtype;
			rcdtype=ihf.GetDataType();  
			if(rcdtype== LINERCD)
			{
				char ladr[2];
				ihf.GetDt(ladr);
				LineAdr=strtoul(ladr,NULL,16); //�õ����Ե�ַ
			}
			else if(rcdtype==SEGRCD)
			{
				char sadr[2];
				ihf.GetDt(sadr);
				SegAdr=strtoul(sadr,NULL,16);  //�õ��ε�ַ

			}
			else if(rcdtype==DATARCD)
			{
				finalAdr=( LineAdr<<16)+(SegAdr<<4) + ihf.GetStartAdr(); //������յ�ַ
				long diffSpace=finalAdr-LastWriteAdr;

				while(diffSpace--)
				{
					ostr<<"00"	;			 //�ڵ�ַ��϶���0
				}
				short len = ihf.GetDataLen(); 
				char * dt= new char[2*len]; 
				ihf.GetDt(dt);				 //�õ����ݼ�¼�е�����
				for(int i=0;i<len;i++)
				{					
					ostr <<dt[2*i]<<dt[2*i+1];//������д������
				}
				delete []dt;
				LastWriteAdr=finalAdr+len;

			}
			else  //��ʱ��Ϊ������¼,����д��Bin�ļ�
			{
				string c=ostr.str();
				string tmp;
				long len=0;
				char hexdt=0;
				len=c.length()/2;
				for(long i=0;i<len;i++)
				{
					tmp=c.substr(2*i,2);
					hexdt=strtoul(tmp.c_str(),NULL,16);
					outf.write(&hexdt,1);
				}

				inf.close();
				outf.close();
				AfxMessageBox("ת�����!");
					
			}
		}


		


	}

	return nRetCode;
}


